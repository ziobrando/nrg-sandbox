Feature: Gestione ispezioni

  Scenario: Inserimento ispezione su segnalazione
    Given un segnale proveniente da sistema di telecontrollo
    And il segnale è visibile sul cruscotto
    When il centro operativo inserisce un'ispezione mirata      # Comando
    Then dovrebbe essere creata un'ispezione                    # Evento a valle
    And ADL dovrebbe essere aggiornato conl'ispezione           # Sistema esterno
    And ...                                                     # Read Model


