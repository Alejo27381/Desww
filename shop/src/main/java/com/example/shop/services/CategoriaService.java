package com.example.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.shop.entities.Categoria;
import com.example.shop.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    // Inyección de dependencias del repositorio de categorías
    private final CategoriaRepository categoriaRepository;

    // Constructor para inicializar el repositorio
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Listar categorias
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener categoria por ID
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Crear nueva categoria
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar categoria
    public Categoria actualizarCategoria(Long id, Categoria categoriaActualizada) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNombreCategoria(categoriaActualizada.getNombreCategoria());
                    return categoriaRepository.save(categoria);
                })
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    // Eliminar una categoria por su ID
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
