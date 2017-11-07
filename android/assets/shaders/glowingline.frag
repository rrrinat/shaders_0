#ifdef GL_ES
precision mediump float;
precision mediump int;
#endif

//SpriteBatch will use texture unit 0
uniform float time;
uniform vec2 resolution;

void main() {
	// Changes the coordinates so that instead of going from zero
	// to the viewport resolution for that axis, it goes from zero to one.
	// i.e.:
	// 	0.0 ≤ x ≤ resolution.x  →  0.0 ≤ x ≤ 2.0
	// 	0.0 ≤ y ≤ resolution.y  →  0.0 ≤ y ≤ 1.0
    vec2 uv = (gl_FragCoord.xy / resolution.xy);
    // Zooms out by a factor of 2.0
    uv *= 2.0;
    // Shifts every axis by -1.0
    uv -= 1.0;

    //base color for the effect
    vec3 finalColor = vec3(0.2, 1.0, 0.0);
    finalColor *= abs(0.05 / (sin(uv.y + sin(uv.x + time) * 0.3) * 20.0));
    gl_FragColor = vec4(finalColor, 1.0);
}