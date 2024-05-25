import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnasayfaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Istemcinin response ile donecek verinin tipini bilip ona göre verinin istemci tarafında
        //dogru gosterilmesi saglaniyor
        response.setContentType("text/html;charset=UTF-8");
        // Response nesnesine icerik yazmak icin PrintWriter nesnesi olusturuluyor
        PrintWriter out = null;
        String responseHeaderTanimi = "<!DOCTYPE html>";
        responseHeaderTanimi += "<html><head>";
        responseHeaderTanimi += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
        responseHeaderTanimi += "<title>Servlet'den Merhaba!</title>";
        responseHeaderTanimi += "</head>";
        try {
            out = response.getWriter();
            out.println(responseHeaderTanimi);
            out.println("<body>");
            out.println("<h1>Anasayfa</h1>");
            // Istek bilgileri yazdiriliyor
            HttpSession session = request.getSession();
            out.println("<p>Bağlantı Adresi: <strong>" + request.getRemoteAddr() + "</strong></p>");
            out.println("<p>İstek URI: <strong>" + request.getRequestURI() + "</strong></p>");
            out.println("<p>Protokol: <strong>" + request.getProtocol() + "</strong></p>");
            out.println("<p>İstek Metodu: <strong>" + request.getMethod() + "</strong></p>");
            out.println("<p>Session Id: <strong>" + session.getId() + "</strong></p>");
            out.println("<p>Session Oluşturulma Zamanı: <strong>" + convertTime(session.getCreationTime()) + "</strong></p>");
            out.println("<p>Session Son İstek Zamanı: <strong>" + convertTime(session.getLastAccessedTime()) + "</strong></p>");
            out.println("<p>Session Yeni Mi?: <strong>" + (session.isNew() ? "Evet" : "Hayır") + "</strong></p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close(); // Yazici nesne kapatiliyor
            // out.flush(); Icerigin yazdirilmasi tetikleniyor
        }
    }
    private String convertTime(Long timeAsLong) {
        Date time = new Date(timeAsLong);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return sdf.format(time);
    }
} // eof class
