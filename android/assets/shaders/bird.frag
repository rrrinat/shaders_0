#version 330 core

layout (location = 0) out vec4 texColor;

uniform sampler2D u_texture;

//input from vertex shader
varying vec2 v_texCoord;

void main()
{
	texColor = texture(u_texture, v_texCoord);
	if (texColor.w < 1.0)
		discard;
}