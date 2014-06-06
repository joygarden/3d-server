<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="sub-header">图片列表</h2>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>标题</th>
            <th>用户</th>
            <th>时间</th>
            <th>图片</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.data}" var="item">
            <tr>
                <td>${item.title}</td>
                <td>${item.user.username}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createDate}" type="both"/></td>
                <td><a class="pic-group" href="${item.fullPath}"><img width="150" height="150"
                                                                      src="${item.fullPath}"></a></td>
                <td>
                    <a href="javascript:delData(${item.id})">删除</a>
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
<c:set var="menu" value="pic" scope="request" />
<script type="text/javascript">
    $(function () {
        //$("#picture-li").addClass("active");
        $('.pic-group').colorbox({maxWidth:'80%',maxHeight:'80%'});
    });
    function delData(id) {
        $('#hidden-form').find('input[name="id"]').val(id);
        $('#myModal').modal();
    }
</script>