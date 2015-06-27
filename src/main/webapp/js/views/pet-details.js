window.PetDetailsView = Backbone.View.extend({

	template : 'pet-details',

	events : {
		'click .save-link' : 'savePet',
		'click .cancel-link' : 'cancel'
	},

	initialize : function() {
		this.model.bind("reset", this.render, this);
	},

	render : function(eventName) {
		var self = this;
		$.get('tpl/' + this.template + '.html', function(tpl) {
			var template = _.template(tpl);
			$(self.el).html(template(self.model.toJSON()));
		});
		return this;
	},

	savePet : function(event) {
		this.model.save({
			name : $('#name').val(),
			age : $('#age').val(),
			comments : $('#comments').val(),
		}, {
			success : function(model, response) {
				app.navigate('pets', true);
			},
			error : function(model, error) {
				console.log(model.toJSON());
				console.log('error.responseText');
			}
		});

		return false;
	},

	cancel : function(event) {
		app.navigate('pets', true);
		return false;
	}
});
