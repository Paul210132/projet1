<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

	<title>Home</title>
	 
<!-- Bootstrap Core CSS -->
   <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

   <!-- MetisMenu CSS -->
   <link href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

   <!-- DataTables CSS -->
   <link href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

   <!-- DataTables Responsive CSS -->
   <link href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

   <!-- Custom CSS -->
   <link href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

     <!-- Custom Fonts -->
   <link href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<ul class="nav navbar-top-links navbar-right">
		<li>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
                       <i class="fa fa-user fa-fw"></i> User <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
                       <li><a href="/myapp"><i class="fa fa-home fa-fw"></i> Home</a>
                       <li class="divider"></li>
                        <li><a href="getAdmin"><i class="fa fa-unlock fa-fw"></i> Administrateur</a>
                       </li>
                       <li><a href="getEmploye"><i class="fa fa-briefcase fa-fw"></i> Employé</a>
                       </li>
                       <li><a href="getClient"><i class="fa fa-dollar fa-fw"></i> Client</a>
                       </li>
                   </ul>
                   <!-- /.dropdown-user -->
               </li>
               <!-- /.dropdown -->
           </ul>
    </nav>
<h1>
	Client
</h1>

<!-- Dropdown des clients -->
  <div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      Choisir un client <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
		 <c:forEach items="${clModel.clients}" var="cl">
		 	<li><a href="getClient/getComptes/${cl.id}">
              ${cl.nom} ${cl.prenom}
		    </a></li>
		 </c:forEach>	
    </ul>
  </div>
  
<!-- Chercher un client (getByMc) -->
     <form action="getClient/getByMc">
     <input type="text" name="mc">
     <input type="submit" value="Rechercher un client">
   </form>

    <c:forEach items="${clModel2.clients}" var="cl">

        <tr>
         <td>${cl.id}</td>
         <td>${cl.nom}</td>
         <td>${cl.prenom}</td>
         <td>${cl.dateNaissance}</td>
        </tr>

      </c:forEach>

<!-- Tableau affichant les comptes du client -->
     <!-- /.row -->
   <div class="row">
       <div class="col-lg-6">
           <div class="panel panel-default">
               <div class="panel-heading">
                   Comptes
               </div>
               <!-- /.panel-heading -->
               <div class="panel-body">
                   <div class="table-responsive">
                       <table class="table table-striped table-bordered table-hover">
                           <thead>
                               <tr>
                                   <th>id</th>
                                   <th>Date et heure de création</th>	
                                   <th>Solde</th>
                                   <th>Type de compte</th>
                                   <th>op</th>
                               </tr>	
                           </thead>
                           <tbody>
         <tr>
            <c:if test="${fn:length(clModel3.comptes) > 0}">
			  <c:forEach items="${clModel3.comptes}" var="cp">
                 <tr>
                    <td>${cp.id}</td>
                    <td>${cp.dateCreation}</td>
                    <td>${cp.solde} Euros</td>
                    <td>${cp.getClass().simpleName}</td>
		            <td>
		            <form action="getClient/getOpe">
		               <input type="submit" value="Opérations">
		            </form>
		            <button type="button" onclick="client/getOpe">Opérations 1 !</button>
		           </td>
                 </tr>
			   </c:forEach>
			 </c:if>
			    <c:if test="${not empty clModel3.exceptionClient}">
			         ${clModel3.exceptionClient}
			    </c:if>
          </tr>
                           </tbody>
                       </table>
                   </div>
                   <!-- /.table-responsive -->
               </div>
               <!-- /.panel-body -->
           </div>
           <!-- /.panel -->
       </div>
       <!-- /.col-lg-6 -->
                
<!-- Affichage des comptes du client et des opérations du compte -->
	 <c:if test="${fn:length(clModel3.comptes) > 0}">
		  <c:forEach items="${clModel3.comptes}" var="cp">
		    ${cp.id}
		    ${cp.dateCreation}
		    ${cp.solde}
		    ${cp.getClass().simpleName}
		    <c:if test="${fn:length(clModel4.operations) == 0}">
		      <p style="font-weight : bold; color : red">il n'y a pas d'opérations sur ce compte.</p>
		    </c:if>
		    <c:forEach items="${clModel4.operations}" var="op">
		      ${op.id}
		      ${op.date}
		      ${op.montant}
		    </c:forEach>
		  </c:forEach>
      </c:if>
      <c:if test="${not empty clModel3.exceptionClient}">
      
               ${clModel3.exceptionClient}
      
      </c:if>
</div>
 
<!-- jQuery -->
   <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

   <!-- Bootstrap Core JavaScript -->
   <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

   <!-- Metis Menu Plugin JavaScript -->
   <script src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

   <!-- DataTables JavaScript -->
   <script src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
   <script src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
   <script src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

   <!-- Custom Theme JavaScript -->
   <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

  <script>
   $(document).ready(function() {
       $('#dataTables-example').DataTable({
           responsive: true
       });
   });
   </script>

</body>
</html>