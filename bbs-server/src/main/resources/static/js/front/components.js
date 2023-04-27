Vue.component("main-header", {
    props: [""],
    data: function() {
        return {
        	user: null
        }
    },
    template: 
    	'<nav class="navbar navbar-default navbar-fixed-top">'+
		    '<div class="container">'+
		        '<div class="navbar-header">'+
		            '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">'+
		                '<span class="sr-only">Toggle navigation</span>'+
		                '<span class="icon-bar"></span>'+
		                '<span class="icon-bar"></span>'+
		                '<span class="icon-bar"></span>'+
		            '</button>'+
		            '<a class="navbar-brand" href="/index.html">论坛</a>'+
		        '</div>'+
		        '<div id="navbar" class="navbar-collapse collapse">'+
		            '<ul class="nav navbar-nav">'+
		                ''+
		            '</ul>'+
		            '<ul class="nav navbar-nav navbar-right hidden-sm">'+
		                '<li v-if="user"><a href="/front/user.html">欢迎，{{user.loginName}}</a></li>'+
		                '<li v-if="user"><a href="#" @click="logout()" >退出</a></li>'+
		                '<li v-if="!user"><a href="login.html" >登录</a></li>'+
		                '<li v-if="!user"><a href="register.html" >注册</a></li>'+
		                '<li><a href="/admin/index.html" target="_blank">管理端</a></li>'+
		            '</ul>'+
		        '</div>'+
		    '</div>'+
		'</nav>'
    ,
    methods: {
		getUser: function(){
			
		},
        logout: function () {
        	//删除本地token
            localStorage.removeItem("token");
            //跳转到登录页面
            location.href = domain + 'login.html';
        }
    },
    created: function() {
    	var user = localStorage.getItem("fuser");
        if(user){
            this.user = JSON.parse(user);
        }
    }
});

Vue.component("main-footer", {
	props: [""],
	data: function() {
	},
	template:
		'<footer style="text-align: center">'+
		    '<p>&copy;Copyright 2020微服汇 版权所有 | <a style=""  href="http://www.miitbeian.gov.cn/">苏ICP备XXXX</a></p>'+
		'</footer>'
});
