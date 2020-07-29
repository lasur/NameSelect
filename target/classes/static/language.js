var x = null;
	$(document).ready( function() {
		x = document.body.getElementsByTagName('*');
		var currentLang = getCookie("lang");
		if (currentLang == null || currentLang == "") {
			document.cookie = "lang=en";
			switchLang('en'); 
		}
		else {
			switchLang(currentLang);
		}
			
	});
	function getCookie(a) {
	    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
	    return b ? b.pop() : '';
	}
	function switchLang(langName) {
		var langs = ["en", "pl"];
		langs.splice(langs.indexOf(langName), 1);
		for (var i = 0; i < x.length; i++) {
			if (x[i].id.indexOf(langName) != -1) {
				x[i].style.display='block';
			}
			if (x[i].id.indexOf('langtog-' + langName) != -1) {
				x[i].style.display='none';
			}
			if (x[i].id.indexOf('ocen') != -1) {
				x[i].style.display='none';
			}
			if (x[i].id.indexOf('przegladaj') != -1) {
				x[i].style.display='none';
			}
			for (var j = 0; j < langs.length; j++) {
				if (x[i].id.indexOf(langs[j]) != -1) {
					x[i].style.display = "none";
				}
				if (x[i].id.indexOf('langtog-' + langs[j]) != -1) {
					x[i].style.display='block';
				}
			}
		}
		document.cookie = "lang="+langName;
	}