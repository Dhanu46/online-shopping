<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="lead">Shop Name</p>




<div class="list-group">


	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c:forEach>

	 
</div>