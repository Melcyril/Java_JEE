<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/InitServlet"><h1>SuperM</h1>
<i>Votre supermarché légendaire</i></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <% if(session.getAttribute("login")!=null){ %>
           <%= session.getAttribute("login") %>
           <%}else{ %>
           Bienvenue
           <%} %>
          </a>
          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
          	<% if(session.getAttribute("login")!=null){%>
          		<li><a class="dropdown-item" href="<%= request.getContextPath() %>/DeconnexionServlet">Se deconnecter</a></li>
          	<%}else{ %>
          		<li><a class="dropdown-item" href="<%= request.getContextPath() %>/AuthentificationServlet">Se connecter</a></li>
          	<%} %>
          	
          	<% if(session.getAttribute("niveau")!=null){%>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/CreerArticleServlet">Creer un article</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/ModifierArticleServlet">Modifier un article</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/SupprimerArticleServlet">Supprimer un article</a></li>
          	<%} %>
          	
          	<li><a class="dropdown-item" href="<%= request.getContextPath() %>/InitServlet">Accueil</a></li>
          	<li><a class="dropdown-item" href="<%= request.getContextPath() %>/PanierServlet">Panier</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

</header>