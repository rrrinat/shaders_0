//combined projection and view matrix
uniform mat4 u_projTrans;

//"in" attributes from our SpriteBatch
attribute vec2 a_position;
attribute vec2 a_texCoord0;
attribute vec4 a_color;

//"out" varyings to our fragment shader
varying vec4 v_color;
varying vec2 v_texCoord;

void main() {
    gl_Position = u_projTrans * vec4(a_position, 0.0, 1.0);
    v_texCoord = a_texCoord0;
    v_color = a_color;
}