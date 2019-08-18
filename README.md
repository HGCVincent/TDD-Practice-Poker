# TDD-CASE
## High Card
#### 1
- given：
player1 [3C]
player2 [2D]
- when：player1  vs  player2
- then："player1 win"
***
#### 2
- given：
player1 [3C]
player2 [AD]
- when：player1  vs  player2 
- then："player2 win"
***
#### 3
- given： 
player1 [2H,3D,**8S**,9C,KD]
player2 [2H,3D,**5S**,9C,KD]
- when：player1  vs  player2
- then："player1 win"
***
## Pair
#### 4
- given：
player1 [2H,3D,8S,9C,KD]
player2 [**3H,3D**,5S,9C,KD]
- when：player1  vs  player2
- then："player2 win"
***
#### 5
- given：
player1 [**8H**,**8S**,3D,9C,KD]
player2 [**3H,3D**,5S,10C,KD]
- when：player1  vs  player2
- then："player1 win"
***
## Two Pairs
#### 6
- given：
player1 [**8H**,**8S**,3D,9C,KD]
player2 [**3H,3C**,**5S**,**5D**,10C,]
- when：player1  vs  player2
- then："player2 win"
***
#### 7
- given：
player1 [**8H,8S,3D**,**3S**,9C]
player2 [**3H,3D**,**5S**,**5D**10C,]
- when：player1  vs  player2
- then："player1 win"
***
#### 8
- given：
player1 [**8H,3C**,**8S**,9C,**3S**]
player2 [**3H,3D**,**8C**,10C,**8D**]
- when：player1  vs  player2
- then："player2 win"
***
#### 9
- given：
player1 [**3S,3C**,8S,9C,KD]
player2 [**3H,3D**,5S,10C,KD]
- when：player1  vs  player2
- then："player1 win"
***
## Three of a kind
#### 10
- given：
player1 [3S,5C,8S,9C,KD]
player2 [**3H,3C,3D**,10C,KD]
- when：player1  vs  player2
- then："player2 win"
***
#### 11
- given：
player1 [**4S,4C,4D**,9C,KD]
player2 [**3H,3C,3D**,10C,KD]
- when：player1  vs  player2
- then："player1 win"
***
### Straight
#### 12
- given：
player1 [**4S,4C,4D**,9C,KD]
player2 [**2H,3C,4D,5S,6D**]
- when：player1  vs  player2
- then："player2 win"
***
### Flush
#### 13
- given：
player1 [**4H,7H,9H,10H,QH**]
player2 [**2H,3C,4D,5S,6D**]
- when：player1  vs  player2
- then："player1 win"
***
#### 14
- given：
player1 [**4H,7H,9H,10H,QH**]
player2 [**4S,7S,9S,10S,QS**]
- when：player1  vs  player2
- then："player2 win"
***
### full house
#### 15
- given：
player1 [**4H,4D,4S,10H,10D**]
player2 [**4S,7S,9S,10S,QS**]
- when：player1  vs  player2
- then："player1 win"
***
#### 16
- given：
player1 [**4H,4D,4S,10H,10D**]
player2 [**5H,5D,5S,10S,10C**]
- when：player1  vs  player2
- then："player2 win"
***
## four of a kind
#### 17
- given：
player1 [**4H,4D,4S,4C,10D**]
player2 [**5H,5D,5S,10S,10C**]
- when：player1  vs  player2
- then："player1 win"
***
#### 18
- given：
player1 [**4H,4D,4S,4C,10D**]
player2 [**5H,5D,5S,5C,10C**]
- when：player1  vs  player2
- then："player2 win"
***
## Straight flush
#### 19
- given：
player1 [**4H,5H,6H,7H,8H**]
player2 [**5H,5D,5S,5C,10C**]
- when：player1  vs  player2
- then："player1 win"
***
