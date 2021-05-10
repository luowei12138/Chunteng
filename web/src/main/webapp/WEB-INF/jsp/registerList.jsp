<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="row" id="app" >
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>挂号信息管理</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content" >
                <form method="post" action="registerList">
                    <div>
                        <input type="hidden" name="pageNo" value="1"/>
                        <input type="hidden" id="queryDepartmentId" value="${queryDepartmentId}">
                        <input type="hidden" id="queryDoctorId" value="${queryDoctorId}">
                        <ul>
                            <li>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input name="idCard" v-model="idCard" type="text"
                                               class="form-control col-md-7 col-xs-12"
                                               value="${queryIdCard}">
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">就诊科室</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="departmentId" name="departmentId" class="form-control"
                                                v-model="departmentId">
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">挂号医师</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="doctorId" v-model="doctorId" name="userId" class="form-control">
                                            <option value="">--请先选择就诊科室--</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">挂号单状态</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="status" v-model="status" name="status" class="form-control"
                                                required>
                                            <option
                                                    <c:if test="${queryStatus == 0 }">selected="selected"</c:if>
                                                    value="0">
                                                --请选择--
                                            </option>
                                            <option
                                                    <c:if test="${queryStatus == 1 }">selected="selected"</c:if>
                                                    value="1">
                                                已挂号，未问诊
                                            </option>
                                            <option
                                                    <c:if test="${queryStatus == 2 }">selected="selected"</c:if>
                                                    value="2">
                                                正在问诊
                                            </option>
                                            <option
                                                    <c:if test="${queryStatus == 3 }">selected="selected"</c:if>
                                                    value="3">
                                                问诊结束
                                            </option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询</button>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>

        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info"
                                   style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">挂号单编号
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        病人姓名
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        性别
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        身份证号
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        就诊科室
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        挂号医师
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        挂号时间
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        创建时间
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        挂号单状态
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 124px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作
                                    </th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr role="row" class="odd" v-for="(item,i) in list">
                                    <td tabindex="0" class="sorting_1">{{item.id}}</td>
                                    <td>{{item.patientName}}</td>
                                    <td v-if="item.patientSex == 1">女</td>
                                    <td v-if="item.patientSex == 2">男</td>
                                    <td>{{item.patientIdCard}}</td>
                                    <td>{{item.departmentName}}</td>
                                    <td>{{item.doctorName}}</td>
                                    <td>{{item.registryTime}}</td>
                                    <td>{{item.createdTime}}</td>
                                    <td>{{item.statusName}}</td>
                                    <td>
                                        <div class="btn-group">
                                            <button type="button" class="viewRegister" @click="rsView(item.id)">
                                                查看详情
                                            </button>
                                        </div>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="row">

                        <div class="col-sm-5">
                            <div class="dataTables_info" id="datatable-responsive_info"
                                 role="status" aria-live="polite">共{{page.total}}条记录
                                {{page.pageNum }}/{{page.pages}}页
                            </div>
                        </div>

                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 id="datatable-responsive_paginate">
                                <ul class="pagination">
                                    <li class="paginate_button previous" v-if="page.pageNum>1"><a
                                            href="javascript:app.queryAllregisterList(app.$data.page.firstPage);"
                                            aria-controls="datatable-responsive" data-dt-idx="0"
                                            tabindex="0">首页</a>
                                    </li>
                                    <li class="paginate_button " v-if="page.pageNum>1"><a
                                            href="javascript:app.queryAllregisterList(app.$data.page.prePage);"
                                            aria-controls="datatable-responsive" data-dt-idx="1"
                                            tabindex="0">上一页</a>
                                    </li>

                                    <li class="paginate_button " v-if="page.pageNum<page.pages"><a
                                            href="javascript:app.queryAllregisterList(app.$data.page.nextPage);"
                                            aria-controls="datatable-responsive" data-dt-idx="1"
                                            tabindex="0">下一页</a>
                                    </li>
                                    <li class="paginate_button next" v-if="page.pageNum<page.pages"><a
                                            href="javascript:app.queryAllregisterList(app.$data.page.lastPage);"
                                            aria-controls="datatable-responsive" data-dt-idx="7"
                                            tabindex="0">最后一页</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>

<script src="${pageContext.request.contextPath }/statics/js/vue.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/vue-axios.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/registerList.js"></script>