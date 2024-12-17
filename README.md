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
**Flavor, Aftertaste, Acidity, Body, Balance, Sweetness**


3. **클래스 생성**: 더 자세한 추천을 위해 원산지인 Origin과 품종인 Variety를 합쳐 **Origin_Variety**를 클래스로 설정했습니다.


5. **결측치 처리**: 결측치는 **삭제**하여 처리했습니다.


6. **일부 클래스 삭제**: 인스턴스 수가 적은 클래스는 학습이 불충분해 성능을 저하시키는 관계로 **삭제**하였습니다.


7. **학습 데이터 조정**: 러닝 커브 분석을 통해 학습 데이터를 전체의 80%로 **크기 조정**했습니다. (조정 후 인스턴스 수 : 468)
  
```
전처리를 거친 데이터셋의 최종 인스턴스 수는 468개이며, 클래스 값은 다음과 같습니다.

- Guatemala Bourbon
- Mexico Typica
- Mexico Bourbon
- Colombia Caturra
- Mexico Caturra
- Guatemala Caturra
```

## 📊 머신러닝 모델
1. **모델 선택**: 사용자의 선호도에 맞는 커피 원두를 추천하기 위해 **랜덤 포레스트(Random Forest)** 알고리즘을 사용했습니다.

```
프로젝트에서 사용한 데이터셋은 특정 범위에 속성 값이 편중되어있습니다.
Random Forest는 여러 개의 하위 샘플을 종합하여 예측하며, 데이터가 밀집된 영역에서도 복잡한 경계나 패턴을 찾아낼 수 있습니다.
따라서 다른 알고리즘과 비교했을 때 데이터셋의 단점을 보완할 수 있을 것이라고 판단했습니다.
```
2. **모델 학습**: 훈련 데이터를 사용하여 모델을 학습시키고, 사용자의 선호도에 가장 가까운 커피 원두를 예측합니다.

## 📈 결과 분석
1. **모델 성능 평가**: 성능을 평가하기 위한 지표로 **정확도, f1-score(정밀도와 재현율의 조화 평균)** 을 사용했습니다.

2. **교차 검증**: **10-fold cross-validation**을 통해 모델을 평가했습니다.

3. **러닝 커브**: J48 결정 트리와 Random Forest 두 알고리즘을 대상으로 정확도 및 f1-score를 측정하고 러닝커브로 나타냈습니다.  

   <img src = https://github.com/kjyyjk/coffee-bean-classifier/blob/main/image/running_curve_acc.png width="70%" height="70%"/>  
   <img src = https://github.com/kjyyjk/coffee-bean-classifier/blob/main/image/running_curve_f1.png width="70%" height="70%"/>

   ```
   모든 지표에서 J48은 학습 데이터셋 20%에서 급감하는 모습을 보였고, 전반적으로 Random Forest의 성능이 더 좋음을 확인할 수 있습니다.
   또한 학습 데이터셋의 크기를 80%로 조정하는 것이 도메인에 가장 적합하다는 것을 확인할 수 있습니다.
   ```

5. **ANOVA**: 80%로 조정한 학습 데이터셋에서 ANOVA 검정을 진행했습니다.
   
   <img src = https://github.com/kjyyjk/coffee-bean-classifier/blob/main/image/anova_acc.png width="50%" height="50%"/>  
   <img src = https://github.com/kjyyjk/coffee-bean-classifier/blob/main/image/anova_f1.png width="50%" height="50%"/>
  
   ```
   모든 지표에서 F-측정값이 F-기각치 보다 큰 것을 확인할 수 있습니다.
   따라서 귀무 가설을 기각함과 동시에 러닝커브에서 확인한 두 알고리즘 간의 성능 차이가 유의미하다는 것을 알 수 있습니다.

   따라서 Random Forest 알고리즘을 사용하여 전체 데이터셋의 80%로 학습하는 것이 좋다고 할 수 있습니다.
   ```
## ⚠️ 한계점
1. 전처리 과정에서 상당 수의 인스턴스를 삭제하여 학습 데이터가 부족합니다. 
2. 추천해줄 수 있는 원두의 종류가 6개로 제한되어있습니다.
3. 원두 전문가가 아니기에 신뢰성이 떨어집니다.

## 🧩 결론
- **모델 성능**: 최종 모델은 사용자의 선호도에 맞는 커피 원두를 **약 52%의 정확도** 로 추천하는 데 성공했습니다.  
  이는 사용자가 클래스의 6가지 원두 중 무작위로 고르는 것보다 본 모델을 사용하는 것이 더 큰 만족감을 제공해 줄 수 있음을 의미합니다.
  
- **향후 개선 사항**: 모델의 성능을 더욱 향상시키기 위해 **모델의 파라미터 조정, 데이터셋 보충, 원두 전문가 자문** 등을 고려할 수 있습니다.
