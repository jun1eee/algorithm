def solution(genres, plays):
    n = len(genres)
    genre_sum = {}
    genre_songs = {}
    for i in range(n):
        genre_sum[genres[i]] = genre_sum.get(genres[i], 0) + plays[i]
        genre_songs.setdefault(genres[i],[]).append((plays[i], i))
    sorted_genres = sorted(genre_sum.keys(), key=lambda x: -genre_sum[x])
    answer = []
    for g in sorted_genres:
        songs = genre_songs[g]
        songs.sort(key=lambda x:(-x[0],x[1]))
        cnt = 0
        for p, i in songs:
            answer.append(i)
            cnt += 1
            if cnt == 2:
                break
    return answer