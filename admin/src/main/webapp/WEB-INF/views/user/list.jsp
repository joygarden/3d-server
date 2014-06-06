<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 class="sub-header">用户列表</h2>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>用户名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>类型</th>
            <th>日期</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.data}" var="item">
            <tr>
                <td>${item.username}</td>
                <td>${item.mdn}</td>
                <td>${item.email}</td>
                <td>
                    <c:if test="${item.roles != 'admin'}">
                        普通用户
                    </c:if>
                    <c:if test="${item.roles == 'admin'}">
                        管理员
                    </c:if>
                </td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createDate}" type="both"/></td>
                <td>${item.address}</td>
                <td>
                    <c:if test="${item.roles != 'admin'}">
                        <a href="javascript:delData(${item.id})">删除</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="/WEB-INF/views/common/page.jsp" %>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                确认删除数据？
            </div>
            <form id="hidden-form" action="del" method="post">
                <input type="hidden" name="id"/>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>
<c:set var="menu" value="user" scope="request" />
<script type="text/javascript">
//    $(function () {
//        $("#user-li").addClass("active");
//    });
    function delData(id) {
        $('#hidden-form').find('input[name="id"]').val(id);
        $('#myModal').modal();
    }
</script>
