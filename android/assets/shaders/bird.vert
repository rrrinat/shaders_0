#version 330 core

//our attributes
layout (location = 0) in vec4 a_position;
layout (location = 1) in vec2 a_texCoord0;

//our camera matrix
uniform mat4 u_projTrans;

//send the color out to the fragment shader
varying vec2 v_texCoord;

void main()
{
	gl_Position = u_projTrans * a_position;
	v_texCoord = a_texCoord0;
}