# coffee-bean-classifier

## 📌 프로젝트 소개
이 프로젝트는 **사용자의 기호에 맞는 커피 원두를 추천해주는 프로그램**입니다.

## 🚀 팀원 소개
| 이름 | 역할 | 담당                         |
|----|----|----------------------------|
| 한수빈 | 팀장 | 보고서 작성 및 발표                |
| 이규린 | 팀원 | 자료조사 및 PPT 제작              |
| 김준영 | 팀원 | 코드 작성 및 프로그램 구현            |
| 전원 | 공통 | 주제 선정, 데이터 탐색 및 전처리, 결과 분석 |

## 🛠 기술 스택
- Java 21
- Weka 3.8.6
- RandomForest Classify Algorithm

## 🧹 데이터 전처리
1. **데이터셋 설명**: 이 프로젝트는 커피 원두의 정보와 특성 별 전문가들의 평가가 포함된 [**데이터셋**](https://www.kaggle.com/datasets/adampq/coffee-quality-with-locations-of-origin)을 사용합니다.


2. **주요 속성 추출**: 원두 추천에 적합하다고 판단되는 6가지 속성만을 추출하여 사용했습니다.  
Flavor, Aftertaste, Acidity, Body, Balance, Sweetness  


3. **클래스 생성**: 더 자세한 추천을 위해 원산지인 Origin과 품종인 Variety를 합쳐 클래스로 설정했습니다.
 

4. **결측치 처리**: 결측치는 **삭제**하여 처리했습니다.


5. **일부 클래스 삭제**: 인스턴스 수가 적은 클래스는 학습이 불충분해 성능을 저하시키는 관계로 삭제하였습니다.


6. **학습 데이터 조정**: 러닝 커브 분석을 통해 데이터를 전체의 80%로 크기 조정했습니다. (클래스 비율 유지)

## 📊 머신러닝 모델
1. **모델 선택**: 사용자의 선호도에 맞는 커피 원두를 추천하기 위해 **k-최근접 이웃(k-NN)** 또는 **랜덤 포레스트**와 같은 추천 알고리즘을 사용했습니다.

2. **모델 학습**: 훈련 데이터를 사용하여 모델을 학습시키고, 사용자의 선호도에 가장 가까운 커피 원두를 예측합니다.

3. **하이퍼파라미터 튜닝**: **그리드 서치**를 사용하여 최적의 하이퍼파라미터를 찾아 모델 성능을 개선했습니다.

## 📈 결과 분석
1. **모델 성능 평가**:
   - 추천 정확도는 **정확도, 정밀도, 재현율** 등을 사용하여 평가했습니다.
   - 예측된 커피 원두와 실제 사용자가 선호한 커피 원두의 일치율을 통해 모델의 성능을 평가했습니다.

2. **교차 검증**: **k-fold 교차 검증**을 통해 모델이 과적합되지 않도록 평가했습니다.

3. **결과 시각화**:
   - 추천된 커피 원두의 특성에 대한 분포를 시각화하여 사용자에게 어떻게 추천이 이루어졌는지 보여줍니다.
   - 모델의 추천 정확도를 비교하는 그래프를 작성했습니다.

## 🧩 결론
- **모델 성능**: 최종 모델은 사용자의 선호도에 맞는 커피 원두를 **[높은 정확도/정확한 추천]** 으로 추천하는 데 성공했습니다.
- **결과 해석**: 모델이 추천한 커피 원두의 특성과 사용자의 선호도가 잘 맞는지 비교한 결과, **[결과 해석]**을 제공합니다.
- **향후 개선 사항**: 모델의 성능을 더욱 향상시키기 위해 **[추천 알고리즘 개선, 추가 데이터 수집, 모델 최적화]** 등을 고려할 수 있습니다.



이 프로젝트는 2024-2학기 데이터마이닝 강의에서 진행한 팀 프로젝트입니다.