# 우리의 용기-v2
 [우리의 용기 : 다회용기 서비스 -v1](https://github.com/Team-SWAcademy/SWAcademy-Android) 을 리디자인 및 Jetpack Compose로 마이그레이션한 버전입니다.
 
![MacBook Air - 8](https://github.com/user-attachments/assets/8fc9bcee-a993-4754-96b7-51db59f6da6a)

## 목차

1. [**서비스 소개**](#1)
1. [**기술 스택**](#2)
1. [**주요 기능**](#3)
1. [**기술적 고민**](#4)
1. [**안드로이드 아키텍처 설계**](#5)

<div id="1"></div>

## 서비스 소개
**♻️ 우리의 용기 (Our Courage)는** 
<br>다회용기 사용을 촉진하고 카페와 협력하여 지속 가능한 소비를 돕는 친환경 플랫폼입니다.

<div id="2"></div>

## 기술 스택
- Jetpack Compose
- MVVM, Clean Architecture, Single Activity Architecture
- Retrofit, OkHttp
- Kotlin Serialization, Moshi
- Coroutine, Flow
- Coil(Image), Naver Map(Map), Zxing(QR Code), Vico(Graph)
- Hilt
- UiState
- ViewModel, Navigation 
- Version Catalog, Ktlint, Code Rabbit

<div id="3"></div>

## 주요 기능
| <img width="150" src="https://github.com/user-attachments/assets/1ef5efbc-0aeb-4672-b7f2-d8f516ad5290"/> | <img width="150" src="https://github.com/user-attachments/assets/81facbe2-de9c-48a5-9976-dce6d5bf5964"/> | <img width="150" src="https://github.com/user-attachments/assets/3adedb4c-dbb1-4289-8e12-a429c10037dc"/> |<img width="150" src="https://github.com/user-attachments/assets/ede0fc7e-9c7e-4662-8903-ee8e859ffa00"/> |
|:-------------------------:|:-------------------------:|:-------------------------:| :-------------------------:|  
|       **`메인화면 / 다회용기 반납`**                                |                                                              **`다회용기 대여`**                                                              |                                                              **`포인트 히스토리`**                                                              |                                                              **`마이페이지`**                                                              |
                      

<div id="4"></div>

## 기술적 고민
### [🔗 XML 뷰 왜 Compose로 마이그레이션 했을까](https://hyeonlog-developer.tistory.com/210)
### [🔗 UseCase, Mapper로 도메인 활용하기](https://hyeonlog-developer.tistory.com/210)
### [🔗 Moshi를 이용해 Json 데이터 잘 활용해보자](https://hyeonlog-developer.tistory.com/210)
### [🔗 Version Catalog 적용](https://hyeonlog-developer.tistory.com/210)
### [🔗 Compose Navigation으로 화면 이동과 데이터 전달](https://hyeonlog-developer.tistory.com/210)

<div id="5"></div>

## 안드로이드 아키텍처 설계

### 아키텍처

![Group 1000000904](https://github.com/user-attachments/assets/6ea379c0-0f1f-4d85-97b0-0de8c2f418ae)

### 폴더링

```
📂 com.example.ourcourage.android
┣ 📂 data
┃ ┣ 📂 datasource
┃ ┃ ┣ 📂 local
┃ ┃ ┣ 📂 remote
┃ ┃ ┃ ┣ 📂 impl
┃ ┣ 📂 interceptor
┃ ┣ 📂 mapper.todomain
┃ ┣ 📂 model
┃ ┃ ┣ 📂 request
┃ ┃ ┣ 📂 response
┃ ┣ 📂 repository // impl
┃ ┣ 📂 service
┃ ┣ 📂 util
┣ 📂 di
┣ 📂 domain
┃ ┣ 📂 mapper
┃ ┣ 📂 model
┃ ┣ 📂 repository
┃ ┣ 📂 usecase
┣ 📂 presentation
┃ ┣ 📂 model
┃ ┣ 📂 type
┃ ┣ 📂 ui
┃ ┃ ┣ 📂 component
┃ ┃ ┃ 📂 home
┃ ┃ ┣ 📂 join
┃ ┃ ┣ 📂 login
┃ ┃ ┣ 📂 multiuse
┃ ┃ ┣ 📂 mypage
┃ ┃ ┣ 📂 navigation
┃ ┃ ┣ 📂 point
┃ ┃ ┣ 📂 scan
┣ 📂 util
┣ 📂 ui.theme
┣ MainActivity
┣ OurCourageApplication
```
