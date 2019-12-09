<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>参数</title>
    <%-- 加载Query文件 >--%>
    <script type="text/html" src="https:/code.jquery.com/jquery-3.2.0.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			// 模拟30000异步请求,进行并发
			var max = 30000;
			for (var i = 1; i <= max; i++) {
				// jquery的post请求，异步请求
				$.post({
					// 请求抢id为1的红包
					url : "userRedPacket/grapRedPacket.do?redPacketId=1&userId=" + i,
					// 成功后的方法
					success: function (result) {
					}
				});

			}

		});
	</script>
</head>
</html>
</%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>参数</title>
<%-- 加载Query文件 >