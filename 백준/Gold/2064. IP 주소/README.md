# [Gold IV] IP 주소 - 2064 

[문제 링크](https://www.acmicpc.net/problem/2064) 

### 성능 요약

메모리: 12180 KB, 시간: 80 ms

### 분류

구현, 비트마스킹

### 제출 일자

2025년 7월 28일 22:34:48

### 문제 설명

<p>네트워크에 연결되어 있는 컴퓨터들은 각각 하나의 IP 주소를 갖게 된다. 그리고 이러한 IP 주소를 갖는 컴퓨터들이 여러 개 모여서 하나의 IP 네트워크를 구성하게 된다. IP 네트워크는 ‘네트워크 주소’와 ‘네트워크 마스크’라는 두 개의 정보로 표현된다.</p>

<p>IP 주소는 네 개의 바이트로 구성되어 있으며, 각각을 10진수로 나타내고(앞에 0을 붙이지 않은 형태로) 사이에 점을 찍어 주소를 표현한다. 바이트이기 때문에 각각의 수는 0부터 255까지의 값을 갖게 된다. 네트워크 주소와 네트워크 마스크 역시 같은 형식으로 나타낸다.</p>

<p>IP 네트워크에 대해 올바르게 이해하기 위해서는 위와 같은 주소를 2진수로 이해하면 된다. 즉, 각각의 바이트를 8자리의 이진수로 나타내고, 이를 네 개 붙여놓은(앞에서부터) 32자리의 이진수를 생각해 보자. IP 네트워크에는 기본적으로 2<sup>m</sup> 개의 컴퓨터(혹은 IP 주소)가 할당될 수 있다. 이 경우의 네트워크 주소는 앞의 32-m 자리가 임의의 수(0 또는 1)로 구성되어 있고, 뒤의 m자리는 0으로 채워지게 된다. 네트워크 마스크는 앞의 32-m 자리가 1로 채워져 있고, 뒤의 m자리는 0으로 채워지게 된다. 이와 같은 IP 네트워크에는 앞의 32-m 자리가 네트워크 주소와 일치하는 모든 IP들이 포함되게 된다.</p>

<p>예를 들어 네트워크 주소가 194.85.160.176이고, 네트워크 마스크가 255.255.255.248인 경우를 생각해 보자. 이 경우, 이 네트워크에는 194.85.160.176부터 194.85.160.183까지의 8개의 IP 주소가 포함된다.</p>

<p>어떤 네트워크에 속해있는 IP 주소들이 주어졌을 때, 네트워크 주소와 네트워크 마스크를 구해내는 프로그램을 작성하시오. 답이 여러 개인 경우에는 가장 크기가 작은(포함되는 IP 주소가 가장 적은, 즉 m이 최소인) 네트워크를 구하도록 한다.</p>

### 입력 

 <p>첫째 줄에 정수 n(1 ≤ n ≤ 1,000)이 주어진다. 다음 n개의 줄에는 각 컴퓨터의 IP 주소가 주어진다.</p>

### 출력 

 <p>첫째 줄에 네트워크 주소를, 둘째 줄에 네트워크 마스크를 출력한다.</p>

