<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="login.do" name="form1">  
                                                            <TABLE cellSpacing=0 cellPadding=0 width=318 border=0>  
                                                                <TBODY>  
                                                                    <TR>  
                                                                        <TD align=left>  
                                                                            <font face="黑体"><span class="content_black_bold">用户名</span>   
                                                                            <input type="text" id="userName" name="userName" value="${userName }" style="WIDTH: 200px" maxLength="20" />  
                                                                            </font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD height=3>  
                                                                            <font face="黑体"><img width="1" height="5" border="0" alt="" src="images/spacer.gif"></font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD align=left>  
                                                                            <font face="黑体"><span class="content_black_bold">密&nbsp;&nbsp;&nbsp;&nbsp;码</span>  
                                                                            <INPUT  style="WIDTH: 200px" type="password" maxLength=32 id="password" name="password" minlength="6" />  
                                                                            </font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD height=3>  
                                                                            <font face="黑体"><img width="1" height="5" border="0" alt="" src="images/spacer.gif"></font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD align=left valign="middle">  
                                                                            <font face="黑体"><span class="content_black_bold">验证码</span>  
                                                                            <INPUT  style="WIDTH: 80px" type="text" maxLength=32 id="validateCode" name="validateCode" minlength="6" />  
                                                                            </font><img src="validatecode.jpg" name="validateCode"> <a href="javascript:newCode();">看不清？</a>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD height=3>  
                                                                            <font face="黑体"><img width="1" height="5" border="0" alt="" src="images/spacer.gif"></font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD height=3>  
                                                                            <font face="黑体"><img width="1" height="5" border="0" alt="" src="images/spacer.gif"></font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                    <TR>  
                                                                        <TD noWrap align=right>  
                                                                            <font face="黑体"><span style="padding-right: 20px;"><input type="submit" value="登  录" onclick="return check();"></span></font>  
                                                                        </TD>  
                                                                    </TR>  
                                                                </TBODY>  
                                                            </TABLE>  
                                                        </form>  


</body>
</html>