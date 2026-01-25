function target_blank() {
	if (!document.getElementsByTagName) {
		return;
	}
	var anchors = document.getElementsByTagName("a");
	var i;
	var enlace;

	for (i = 0; i < anchors.length; i++) {
		var enlace = anchors[i];
		if (enlace.getAttribute("href") && enlace.getAttribute("rel") == "external") {
			enlace.target = "_blank";
		}
	}

}

function formularios() {
	if (!document.getElementsByTagName) {
		return;
	}

	var los_inputs = document.getElementsByTagName("input");
	for (var i=0; i < los_inputs.length; i++) {
		var el_input = los_inputs[i];
		if (el_input.getAttribute("type").toLowerCase() == "text" || el_input.getAttribute("type").toLowerCase() == "password") {
			el_input.onfocus = function() {
					if ((this.value.charCodeAt(0) == 32 || this.value.charCodeAt(0) == 160) && this.value.length == 1) {
						this.value = "";
					}
				} ;
		}
	}
	
	var los_textareas = document.getElementsByTagName("textarea");
	for (var i=0; i < los_textareas.length; i++) {
		var el_textarea = los_textareas[i];
		el_textarea.onfocus = function() {
				if (this.value.charCodeAt(0) == 32 || this.value.charCodeAt(0) == 160 && this.value.length == 1) {
					this.value = "";
				}
			} ;
	}	
}

function attachEventListener(target, eventType, functionRef, capture) {
    if (typeof target.addEventListener != "undefined") {
        target.addEventListener(eventType, functionRef, capture);
    } else if (typeof target.attachEvent != "undefined") {
        target.attachEvent("on" + eventType, functionRef);
    } else {
        return false;
    }

    return true;
}

attachEventListener(window, "load", formularios, false);
attachEventListener(window, "load", target_blank, false);