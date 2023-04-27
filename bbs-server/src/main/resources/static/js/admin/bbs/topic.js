$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '头像', field: 'member.avatarUrl' ,
				formatter: function (value, row, index) {
					return '<img width="30px" height="30px" src="'+value+'" />';
				}}, 			
			{ title: '昵称', field: 'member.nickname' }, 			
			{ title: '话题', field: 'title' }, 			
			{ title: '点赞', field: 'likeNumber' }, 			
			{ title: '评论', field: 'replyNumber' }, 			
			{ title: '匿名', field: 'anonymous',
				formatter: function (value, row) {
					if(value == 1){
						return "是";
					}else if(value == 0){
						return "否";
					}
			}}, 			
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'topic/list',
	        cache: false,
	        striped: true,
	        pagination: true,
	        pageSize: 10,
	        pageNumber: 1,
	        sidePagination: 'server',
	        pageList: [10, 25, 50],
	        columns: columns,
	        queryParams: function (params) {
	        	return {
		        	page: params.offset / 10 + 1,
		        	limit: params.limit,
		        	title: vm.q.title
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		q: {
			title: ''
		},
		topic: {
			category: {},
			member: {}
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.topic = {};
		},
		detail: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "详情";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.topic.id == null ? "topic/save" : "topic/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.topic),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "topic/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "topic/info/"+id, function(r){
                vm.topic = r.topic;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		}
	}
});