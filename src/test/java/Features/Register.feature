Feature: Register Feature
  Scenario: Obss Footer Geldiğinin Doğrulanması
    Given OBSS siteye Girilir
    When Cerezler Kabul Edilir
    And Search Ikonuna Tıklanır
    And Text Alana Automation Yazılır
    And Sonuçların Geldiği Doğrulanır
    And Çıkan Sonuçlardan Ilkine Tıklanır
    And Testing & Automation Sayfasının Açıldığı Doğrulanır
    And Sayfanın En Altına Gidilir
    Then Obss Footer Geldiği Doğrulanır