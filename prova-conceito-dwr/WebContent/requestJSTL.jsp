<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Page Data Example</title>
  </head>

  <body>
    <h3>&#160;</h3>

    <table border="1" width="539">
      <tr>
        <td colspan="2" width="529" bgcolor="#0000FF">
          <b>
            <font color="#FFFFFF" size="4">HTTP
            Request(pageContext.request.)</font>
          </b>
        </td>
      </tr>

      <tr>
        <td width="210">Access Method</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.method}" />
        </td>
      </tr>

      <tr>
        <td width="210">Authentication Type</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.authType}" />
        </td>
      </tr>

      <tr>
        <td width="210">Context Path</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.contextPath}" />
        </td>
      </tr>

      <tr>
        <td width="210">Path Information</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.pathInfo}" />
        </td>
      </tr>

      <tr>
        <td width="210">Path Translated</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.pathTranslated}" />
        </td>
      </tr>

      <tr>
        <td width="210">Query String</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.queryString}" />
        </td>
      </tr>

      <tr>
        <td width="210">Request URI</td>

        <td width="313">&#160; 
        <c:out value="${pageContext.request.requestURI}" />
        </td>
      </tr>
    </table>

  </body>
</html>