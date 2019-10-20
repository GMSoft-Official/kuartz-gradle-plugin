# Kuartz QueryDSL Gradle Plugin

## Giriş

Bu repository bir spring projesinde kullabilecek queryDSL teknolojisine ait bir gradle pluginidir. Plugin Java dilini 
destekleyecek şekilde tasarlanmıştır. Groovy dilini kullanılarak geliştirilen plugin herhangi bir artifactory de 
yayınlanmamıştır. 

> **Not:** Plugini kullanabilmek için gradle tasklarının içerisinde publish task grubunun içerisinde  `publishToMavenLocal` taskı
>kullanılmalıdır.

Plugin Querydsl sınıflarını proje genelinde kolayca oluşturulmasını sağlar. Plugini kullanmak isteyen geliştirici Hibernate,
Spring ve Querydsl kütüphanelerine bağımlılığı olması gerekmektedir.
---
#### Konfigürasyon

* **library**

Plugin Querdsl annotation processor versiyonu varsayılan olarak `com.querydsl:querydsl-apt:4.2.1` ayarlanmıştır.

* **qdslSourceDir**

Querydsl sınıflarının oluşturulacağı package bilgisidir. Varsayılan `src/main/java` dır.

* **entityQueryPrefix**

Oluşturulacak querydsl sınıflarının isim prefix'idir. Varsayılan: boş.

* **entityQuerySuffix**

Oluşturulacak querydsl sınıflarının isim suffix'idir. Varsayılan: `Query`

* **entityQueryPackageSuffix**

Oluşturulacak querydsl sınıflarının package suffix bilgisidir. Varsayılan `.query`




