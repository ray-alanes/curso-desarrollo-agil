# language: es

Característica: Al obtener el punto de interes de un servicio más cercano a mi ubicación actual, queremos validar que la posicion del usuario
	sea correcta

	Escenario: Al obtener el punto más cercano a mi ubicación, validamos que la latitud sea negativa
		Dado estoy en la ubicacion 34.603765 y 58.381570
		Cuando pido el POI mas cercano a la ubicacion del servicio pizzerias
		Entonces el servicio me devuelve el mensaje "la latitud debe ser negativa"