define(['jquery.min', 'underscore', 'backbone',
	"text!../users/Users.html"], function($, _, Backbone, Users ) {

		$.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
			options.url = "http://localhost:8080/Przychodnia" + options.url;
			});
		
		var Users = Backbone.Collection.extend({
			url:'/users/userlist'	
		});
	
		var UserListTable = Backbone.View.extend({
			el : '.page',
			render : function() {
				var that = this;
				console.log('wejszlo w View');
				console.log(this.$el);
				var users = new Users();
				users.fetch({
					succes: function(users){
						that.$el.html('!CONTENT SHOULD SHOW HERE!');
					},
					error: function(){
						that.$el.html('cos sie zesralo na requescie');
					}
				})
			}
		});

		var Router = Backbone.Router.extend({
			routes : {
				'' : 'home'
			}
		});
		var userListTable = new UserListTable();

		var router = new Router();
		router.on('route:home', function() {
			console.log('wejszlo do routera');
			userListTable.render();
		});

		Backbone.history.start();
		
});