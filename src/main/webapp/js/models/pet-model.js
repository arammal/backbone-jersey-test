window.Pet = Backbone.Model.extend({
	urlRoot : "resource/pets",
	defaults : {
		"id" : null,
		"name" : "",
		"age" : "",
		"comments" : ""
	}
});

window.PetCollection = Backbone.Collection.extend({
	model : Pet,
	comparator : function(pet) {
		return pet.get("id");
	},

	url : "resource/pets"
});