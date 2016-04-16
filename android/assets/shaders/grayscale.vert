//our camera matrix
uniform mat4 u_projTrans;

//our attributes
attribute vec4 a_position;
attribute vec2 a_texCoord0;
attribute vec4 a_color;

//send the color out to the fragment shader
varying vec4 v_color;
varying vec2 v_texCoord;

void main() {
    gl_Position = u_projTrans * a_position;
    v_texCoord = a_texCoord0;
    v_color = a_color;
}