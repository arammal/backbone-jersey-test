window.PetTableView = Backbone.View.extend({

	tagName : 'table',
	events : {
		'click .delete-link' : 'deletePet'
	},

	initialize : function() {
		this.model.bind("reset", this.render, this);
		this.model.bind("destroy", this.render, this);
	},

	render : function(eventName) {
		$(this.el).empty();
		this.model.sort();
		_.each(this.model.models, function(pet) {
			$(this.el).append(new PetRowView({
				model : pet
			}).render().el);
		}, this);
		return this;
	},

	deletePet : function(event) {
		var id = $(event.target).attr('attr-id');
		var model = _(this.model.models).findWhere({
			id : parseInt(id)
		});

		model.destroy({
			success : function() {
				console.log('Model [' + model.id + '] was deleted.');
			}
		});
	}
});

window.PetRowView = Backbone.View.extend({

	template : 'pet-row',
	tagName : "tr",

	initialize : function() {
		this.model.bind("change", this.render, this);
		this.model.bind("destroy", this.close, this);
	},

	render : function(eventName) {
		var self = this;
		$.get('tpl/' + this.template + '.html', function(tpl) {
			var template = _.template(tpl);
			$(self.el).html(template(self.model.toJSON()));
		});
		return this;
	}
});