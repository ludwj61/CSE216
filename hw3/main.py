from codebase.two_d_point import TwoDPoint
from codebase.quadrilateral import Quadrilateral
from codebase.rectangle import Rectangle

def main():
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

    q = Quadrilateral(0, 1, 1, 1, 1, 0, 0, 0)
    print(q.smallest_x())
    print(q.side_lengths())
    r = Rectangle(0, 1, 1, 1, 1, 0, 0, 0)

    print("area: " + str(r.area()))
    print("center: " + str(r.center()))

main()
