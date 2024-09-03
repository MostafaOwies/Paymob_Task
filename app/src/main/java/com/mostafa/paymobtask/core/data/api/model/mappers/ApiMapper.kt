package com.mostafa.paymobtask.core.data.api.model.mappers

interface ApiMapper<E, D> {
  fun mapToDomain(apiEntity: E): D
}
