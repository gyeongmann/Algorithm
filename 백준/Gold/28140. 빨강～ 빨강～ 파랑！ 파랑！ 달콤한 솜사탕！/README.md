# [Gold V] 빨강~ 빨강~ 파랑! 파랑! 달콤한 솜사탕! - 28140 

[문제 링크](https://www.acmicpc.net/problem/28140) 

### 성능 요약

메모리: 455716 KB, 시간: 2392 ms

### 분류

이분 탐색

### 제출 일자

2025년 7월 29일 23:50:11

### 문제 설명

<p>알파벳 대문자로 이루어진 길이 $N$의 문자열 $S=S_0S_1S_2\cdots S_{N-1}$가 주어진다.</p>

<p>구간 $[l, r]$이 주어질 때, 아래의 규칙을 만족하는 정수 $a,\ b,\ c,\ d$를 찾으면 당신은 달콤한 솜사탕을 얻을 수 있다.</p>

<ul>
	<li>$S_a=S_b=$<code><span style="color:#c0392b;">R</span></code></li>
	<li>$S_c=S_d=$<code><span style="color:#c0392b;">B</span></code></li>
	<li>$l \leq a \lt b \lt c \lt d \leq r$</li>
</ul>

<p>구간이 $Q$번 주어질 때 달콤한 솜사탕을 얻을 수 있으면 그때의 $a,\ b,\ c,\ d$를 아무거나 하나 출력하고, 얻을 수 없으면 <code><span style="color:#c0392b;">-1</span></code>을 출력한다.</p>

### 입력 

 <p>첫째 줄에 두 정수 $N$, $Q$가 공백으로 구분되어 주어진다. ($4 \le N \le 1\ 000\ 000;\ 1 \le Q \le 1\ 000\ 000$)  </p>

<p>둘째 줄에 문자열 $S$가 주어진다.</p>

<p>다음 $Q$개의 줄에 두 정수 $l$, $r$이 공백으로 구분되어 주어진다. ($0 \le l \le r \le N-1$)  </p>

### 출력 

 <p>매 쿼리마다 달콤한 솜사탕을 얻을 수 있는 경우 가능한 $a,\ b,\ c,\ d$를 아무거나 하나 공백으로 구분하여 출력하고, 솜사탕을 얻을 수 없는 경우 <span style="color:#e74c3c;"><code>-1</code></span>을 출력한다.</p>

