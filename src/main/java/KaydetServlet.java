import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class KaydetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Istemcinin response ile donecek verinin tipini bilip ona göre verinin dogru
        //gosterilmesi saglaniyor
        response.setContentType("text/html;charset=UTF-8");
        // Response nesnesine icerik yazmak icin PrintWriter nesnesi olusturuluyor
        PrintWriter out = null;
        String responseHeaderTanimi = "<html><head>";
        responseHeaderTanimi += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
        responseHeaderTanimi += "<title>Kayıt Sayfası</title>";
        responseHeaderTanimi += "</head>";
        try {
            out = response.getWriter();
            out.println(responseHeaderTanimi);
            request.setCharacterEncoding("UTF-8"); // throws UnsupportedEncodingException
            String isim = request.getParameter("isim");
            isim = isim.trim();
            String soyisim = request.getParameter("soyisim");
            soyisim = soyisim.trim();
            String strCinsiyet = "";
            String cinsiyet = request.getParameter("cinsiyet");
            if (cinsiyet != null) {
                Integer intCinsiyet = Integer.parseInt(cinsiyet);
                if (intCinsiyet == 1)
                    strCinsiyet = "Bay";
                else if (intCinsiyet == 2)
                    strCinsiyet = "Bayan";
            }
            String sinif = request.getParameter("sinif");
            out.println("<body>");
            out.println("<h1>Girilen Bilgiler</h1>");
            // İstek Bilgileri yazdiriliyor
            out.println("<p>İsim: " + isim + "</p>");
            out.println("<p>Soyisim: " + soyisim + "</p>");
            out.println("<p>Cinsiyet: " + strCinsiyet + "</p>");
            out.println("<p>Sınıf: " + sinif + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            if (out != null)
                out.close(); // Yazici nesne kapatiliyor
        }
    }
}