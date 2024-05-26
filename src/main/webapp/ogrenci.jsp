<%@ page import='Ogrenci' %>
<html>
   <head>
      <title>Using JavaBeans in JSP</title>
   </head>
   <body>
      <center>
         <h2>Using JavaBeans in JSP</h2>
         <&
         Ogrenci ogrenci = new Ogrenci();
         ogrenci.setAd = 'Ali';
         out.print(ogrenci.getAd());
         &>
      </center>
   </body>
</html>