<%--
  Created by IntelliJ IDEA.
  User: liaozhisong
  Date: 5/30/14
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty page.data}">
<ul class="pagination">
    <c:if test="${page.pageNo==1}">
        <li class="disabled"><span>&laquo;</span></li>
    </c:if>
    <c:if test="${page.pageNo!=1}">
        <li><a href="list?pageNo=1&pageSize=${page.pageSize}&keyword=${param.keyword}">&laquo;</a></li>
    </c:if>
    <c:forEach begin="1" end="${page.totalPageCount}" var="i">
        <c:if test="${page.pageNo==i}">
            <li class="active"><span>${i}</span></li>
        </c:if>
        <c:if test="${page.pageNo!=i}">
            <li><a href="list?pageNo=${i}&pageSize=${page.pageSize}&keyword=${param.keyword}">${i}</a></li>
        </c:if>
    </c:forEach>
    <c:if test="${page.pageNo==page.totalPageCount}">
        <li class="disabled"><span>&raquo;</span></li>
    </c:if>
    <c:if test="${page.pageNo!=page.totalPageCount}">
        <li><a href="list?pageNo=${page.totalPageCount}&pageSize=${page.pageSize}&keyword=${param.keyword}">&raquo;</a>
        </li>
    </c:if>
</ul>
</c:if>