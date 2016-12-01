public class JspConfiguration {
	public void jspService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JspFactory jspxFactory = null;
		PageContext pageContext = null;
		jspxFactory = JspFactory.getDefaultFactory();
		pageContext = jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
	}
}


