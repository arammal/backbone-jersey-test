window.PetPageView = Backbone.View.extend({

	tagName : 'div',
	events : {
		'click .create-link' : 'createPet'
	},
	template : 'pet-page',

	initialize : function() {
		this.petTable = new PetTableView({
			model : this.model
		});
	},

	render : function() {
		var self = this;
		$.get('tpl/' + this.template + '.html', function(tpl) {
			var template = _.template(tpl);
			$(self.el).html(template);
			$(self.el).append(self.petTable.render().el);
		});
		return this;
	},

	createPet : function(event) {
		app.navigate("newPet", true);
		return false;
	}
});
