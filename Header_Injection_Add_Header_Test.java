public class Header_Injection_Add_Header_Test {
    public void doWork(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        response.addHeader("name", username);
    }
}