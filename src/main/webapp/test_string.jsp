<%@ taglib uri = "jakarta/tags/core" prefix = "c" %>
<%@ taglib uri = "jakarta/tags/functions" prefix = "fn" %>
<html>
     <head>
         <title>JSTL Fonksiyonları</title>
     </head>
     <body>
         <c:set var ="str" value ="Bu bir test String\’idir."/>
         <c:if test ="${fn:contains(str, 'test')}">
             <p>test bulundu.<p>
         </c:if>
         <c:if test ="${fn:contains(str, 'TEST')}">
             <p>TEST bulundu.<p>
         </c:if>
     </body>
</html>