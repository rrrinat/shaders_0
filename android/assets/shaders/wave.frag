#ifdef GL_ES
precision mediump float;
precision mediump int;
#endif

const float PI = 3.14159265359;
uniform vec2 resolution;

void main() {

    vec2 position = gl_FragCoord.xy / resolution.xy;
    float wave = sin(2.0 * PI * position.x);
    wave = wave + 1.0;
    wave = wave / 2.0;
    gl_FragColor = vec4(vec3(wave), 1.0);
}