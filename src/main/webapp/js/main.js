var AppRouter = Backbone.Router.extend({

	routes : {
		"" : "list",
		"pets" : "list",
		"pets/:id" : "petDetails",
		"newPet" : "newPet"
	},

	list : function() {
		var petList = new PetCollection();
		petList.fetch({
			success : function() {
				$('body').html(new PetPageView({
					model : petList
				}).render().el);
			}
		});
	},

	petDetails : function(id) {
		console.log(id);
		var pet = new Pet({
			id : id
		});
		pet.fetch({
			success : function() {
				$('body').html(new PetDetailsView({
					model : pet
				}).render().el);
			}
		});
	},

	newPet : function() {
		$('body').html(new PetDetailsView({
			model : new Pet()
		}).render().el);
	},
});

app = new AppRouter();
Backbone.history.start();
