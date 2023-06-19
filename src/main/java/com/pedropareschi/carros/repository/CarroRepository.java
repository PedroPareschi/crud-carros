package com.pedropareschi.carros.repository;

import com.pedropareschi.carros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {


    @Query("SELECT c FROM Carro c WHERE (:modelo IS NULL OR c.modelo LIKE %:modelo%) " +
            "AND (:dataInicial like '' OR c.data >= to_timestamp(:dataInicial,'YYYY-MM-DD')) " +
            "AND (:dataFinal like '' OR c.data <= to_timestamp(:dataFinal, 'YYYY-MM-DD')) " +
            "AND (:valorMinimo IS NULL OR c.valor >= :valorMinimo) " +
            "AND (:valorMaximo IS NULL OR c.valor <= :valorMaximo)")
    List<Carro> listarCarrosComFiltro(@Param("modelo") String modelo,
                                      @Param("dataInicial") String dataInicial,
                                      @Param("dataFinal") String dataFinal,
                                      @Param("valorMinimo") Double valorMinimo,
                                      @Param("valorMaximo") Double valorMaximo);
}

