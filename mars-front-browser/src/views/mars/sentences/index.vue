<style>
body{
  background-image: url("../../bg-stars.jpg");
  background-size: 100%;
}
</style>

<template>
  <div class="app-container">
    <div style="width: 1400px;background: rgba(255,255,255,0.7);padding: 30px;margin: 0 auto" >
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="来源" prop="source">
          <el-input
            v-model="queryParams.source"
            placeholder="请输入来源"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table v-loading="loading" :data="sentencesList" @selection-change="handleSelectionChange">
        <el-table-column label="句子内容text" align="center" prop="contentText" />
        <el-table-column label="句子内容html" align="center" prop="contentHtml" />
        <el-table-column label="来源" align="center" prop="source" />
        <el-table-column label="置顶" align="center" prop="isTop" />
        <el-table-column label="用户id" align="center" prop="userId" />
        <el-table-column label="投稿者" align="center" prop="author" />
        <el-table-column label="投稿者email" align="center" prop="authorEmail" />
        <el-table-column label="投稿者的话" align="center" prop="authorTalk" />
        <el-table-column label="1-已发布/2-审核中" align="center" prop="type" />
        <el-table-column label="允许展示email" align="center" prop="permitShowEmail" />
        <el-table-column label="排序" align="center" prop="sort" />
        <el-table-column label="备注" align="center" prop="remark" />
      </el-table>

      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />

      <!-- 添加或修改句子对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="句子内容text" prop="contentText">
            <el-input v-model="form.contentText" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="句子内容html" prop="contentHtml">
            <el-input v-model="form.contentHtml" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <b>句子内容：</b><br>
          <editor v-model="form.contentHtml" :min-height="192" :uploadUrl="uploadUrl" style="margin-bottom: 20px;margin-top: 5px"/>
          <el-form-item label="来源" prop="source">
            <el-input v-model="form.source" placeholder="请输入来源" />
          </el-form-item>
          <el-form-item label="置顶" prop="isTop">
            <el-input v-model="form.isTop" placeholder="请输入置顶" />
          </el-form-item>
          <el-form-item label="用户id" prop="userId">
            <el-input v-model="form.userId" placeholder="请输入用户id" />
          </el-form-item>
          <el-form-item label="投稿者" prop="author">
            <el-input v-model="form.author" placeholder="请输入投稿者" />
          </el-form-item>
          <el-form-item label="投稿者email" prop="authorEmail">
            <el-input v-model="form.authorEmail" placeholder="请输入投稿者email" />
          </el-form-item>
          <el-form-item label="投稿者的话" prop="authorTalk">
            <el-input v-model="form.authorTalk" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="允许展示email" prop="permitShowEmail">
            <el-input v-model="form.permitShowEmail" placeholder="请输入允许展示email" />
          </el-form-item>
          <el-form-item label="排序" prop="sort">
            <el-input v-model="form.sort" placeholder="请输入排序" />
          </el-form-item>
          <el-form-item label="备注" prop="remark">
            <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="删除标记" prop="delFlag">
            <el-input v-model="form.delFlag" placeholder="请输入删除标记" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<style>
.pagination-container[data-v-72233bcd] {
  background: none;
}
</style>

<script>
import { listSentences, getSentences, delSentences, addSentences, updateSentences } from "@/api/mars/sentences";

export default {
  name: "Sentences",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 句子表格数据
      sentencesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contentText: null,
        contentHtml: null,
        source: null,
        isTop: null,
        userId: null,
        author: null,
        authorEmail: null,
        authorTalk: null,
        type: null,
        permitShowEmail: null,
        sort: null,
        delFlag: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        contentText: [
          { required: true, message: "句子内容text不能为空", trigger: "blur" }
        ],
        contentHtml: [
          { required: true, message: "句子内容html不能为空", trigger: "blur" }
        ],
      }
      //富文本 上传url
       ,uploadUrl: process.env.VUE_APP_BASE_API + "/common/upload"
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询句子列表 */
    getList() {
      this.loading = true;
      listSentences(this.queryParams).then(response => {
        this.sentencesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        sentencesId: null,
        contentText: null,
        contentHtml: null,
        source: null,
        isTop: null,
        userId: null,
        author: null,
        authorEmail: null,
        authorTalk: null,
        type: null,
        permitShowEmail: null,
        sort: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        delFlag: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.sentencesId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加句子";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const sentencesId = row.sentencesId || this.ids
      getSentences(sentencesId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改句子";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.sentencesId != null) {
            updateSentences(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSentences(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const sentencesIds = row.sentencesId || this.ids;
      this.$modal.confirm('是否确认删除句子编号为"' + sentencesIds + '"的数据项？').then(function() {
        return delSentences(sentencesIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('mars/sentences/export', {
        ...this.queryParams
      }, `sentences_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

