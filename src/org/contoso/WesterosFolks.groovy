package org.contoso

class WesterosFolks {
    private def static getRandomLastName() {
        def listLastNames = []
        listLastNames << "Lannister"
        listLastNames << "Targeryen"
        listLastNames << "Martell"
        listLastNames << "Stark"
        listLastNames << "Barethoen"
        listLastNames << "Tarly"
        listLastNames << "Snow"
        listLastNames << "Bolton"
        listLastNames << "Baelish"
        listLastNames << "Waters"
        listLastNames << "Sand"
        listLastNames << "Pyke"
        listLastNames << "Flowers"
        listLastNames << "Martell"

        // Collections.shuffle(listLastNames, new Random())
        // return listLastNames.first()
        // return listLastNames.get(new Random().nextInt(listLastNames.size()))
        // return listLastNames.get(new SecureRandom().nextInt(listLastNames.size()))

        return listLastNames.get(new SimpleRandom(listLastNames.size()).nextInt())
    }

    private def static getRandomFirstName() {
        def listFirstNames = []
        listFirstNames << "Tywin"
        listFirstNames << "Jamie"
        listFirstNames << "Cersie"
        listFirstNames << "Tyrion"
        listFirstNames << "Aerys"
        listFirstNames << "Rhaegar"
        listFirstNames << "Viserys"
        listFirstNames << "Daenerys"
        listFirstNames << "Samwell"
        listFirstNames << "John"
        listFirstNames << "Roose"
        listFirstNames << "Petyr"

        // Collections.shuffle(listFirstNames, new Random())
        // return listFirstNames.first()
        // return listFirstNames.get(new Random().nextInt(listFirstNames.size()))
        // return listFirstNames.get(new SecureRandom().nextInt(listFirstNames.size()))

        return listFirstNames.get(new SimpleRandom(listFirstNames.size()).nextInt())
    }

    private def static getRandomIntransitiveVerb() {
        def listIntransitiveVerbs = []
        listIntransitiveVerbs << "born"
        listIntransitiveVerbs << "fought"
        listIntransitiveVerbs << "killed"
        listIntransitiveVerbs << "murdered"
        listIntransitiveVerbs << "stopped"
        listIntransitiveVerbs << "sat"
        listIntransitiveVerbs << "read"
        listIntransitiveVerbs << "drank"
        listIntransitiveVerbs << "poisoned"
        listIntransitiveVerbs << "struck"
        listIntransitiveVerbs << "stood"
        listIntransitiveVerbs << "slept"
        listIntransitiveVerbs << "ate"

        // Collections.shuffle(listIntransitiveVerbs, new Random())
        // return listIntransitiveVerbs.first()
        // return listIntransitiveVerbs.get(new Random().nextInt(listIntransitiveVerbs.size()))
        // return listIntransitiveVerbs.get(new SecureRandom().nextInt(listIntransitiveVerbs.size()))

        return listIntransitiveVerbs.get(new SimpleRandom(listIntransitiveVerbs.size()).nextInt())
    }

    private def static getRandomPlace() {
        def listPlaces = []
        listPlaces << "Castle Black"
        listPlaces << "Winterfell"
        listPlaces << "Moat Cailin"
        listPlaces << "Ironman's Bay"
        listPlaces << "Harrenhal"
        listPlaces << "Dragonstone"
        listPlaces << "Lannisport"
        listPlaces << "King's Landing"
        listPlaces << "Highgarden"
        listPlaces << "Blackwater's Bay"
        listPlaces << "Qarth"
        listPlaces << "Volantis"
        listPlaces << "Meereen"
        listPlaces << "Braavos"
        listPlaces << "Astapor"
        listPlaces << "Yunkai"
        listPlaces << "Lys"
        listPlaces << "Pentos"

        // Collections.shuffle(listPlaces, new Random())
        // return listPlaces.first()
        // return listPlaces.get(new Random().nextInt(listPlaces.size()))
        // return listPlaces.get(new SecureRandom().nextInt(listPlaces.size()))

        return listPlaces.get(new SimpleRandom(listPlaces.size()).nextInt())
    }

    private def static getRandomPunctuation() {
        def listPunctuations = []
        listPunctuations << '.'
        listPunctuations << '?'
        listPunctuations << '!'

        // Collections.shuffle(listPunctuation, new Random())
        // return listPunctuations.first()
        // return listPunctuation.get(new Random().nextInt(listPunctuation.size()))
        // return listPunctuations.get(new SecureRandom().nextInt(listPunctuations.size()))

        return listPunctuations.get(new SimpleRandom(listPunctuations.size()).nextInt())
    }

    def static getRandomName() {
        return getRandomFirstName() + " " + getRandomLastName()
    }

    def static getRandomStory() {
        def separator = ' '
        return getRandomName() + separator + getRandomIntransitiveVerb() + separator + "at" + separator + getRandomPlace() + '.'
    }
}
