$(document).ready(
			function(){
				$.getJSON('http://localhost:8080/FitnessTracker/activities.json', {
					ajax:'true'
				}, function(data){
					var html = '<option value=""> -- Please select one -- </option>';
					var length = data.length;
					for(var i = 0; i < len;){
						html += '<option value="' + data[i].desc + '">'
							+ data[i].desc + '</option>'
					}
					html += '</option>';
					$('#activities').html(html);
				});
			});