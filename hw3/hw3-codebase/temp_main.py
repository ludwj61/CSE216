from two_d_point import TwoDPoint

points = TwoDPoint.from_coordinates([2, 2, 3.0, 3.1, 2.3, 1.2])
for p in points:
    print(p)


p1 = TwoDPoint(2, 2)
p2 = TwoDPoint(4, 4)

print(p1 - p2)

p3 = TwoDPoint(2, 2)
print(p1 == 2)

li = [1, 2,3,4,5,6]
print(li[0:3])
