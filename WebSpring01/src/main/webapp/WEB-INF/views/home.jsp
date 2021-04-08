<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
  <img src="<%=request.getContextPath()%>/resources/10.jfif"/>

</div>
</body>
</html>

<!-- spring에서 dbcp설정 
    1 ojdbc가 설정되있어야함/ ojdbc가 webin/lib에 추가한다.
    2 빌드패스 걸어주기
    3 pom.xml에 dependence 추가
    
    https://mvnrepository.com/artifact/org.springframework/spring-jdbc
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.6.RELEASE</version>
   </dependency> 
   
   4
  오라클, 서버위치, 아이디 비번 드라이브 등 설정 
	<beans:bean class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	    <beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></beans:property>
	    <beans:property name="url" value="jdbc:oracle:thin:localhost:1521:xe"></beans:property>
	    <beans:property name="username" value="c##scott"></beans:property>
	    <beans:property name="password" value="tiger"></beans:property>	       		
	</beans:bean>





 -->